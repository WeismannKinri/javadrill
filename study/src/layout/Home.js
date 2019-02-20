import { Layout, Menu, Icon } from 'antd';
import React from 'react';
import SiderMenu from "./SiderMenu";
import HomePage from "../content/HomePage";

const { Header, Sider, Content } = Layout;



class Home extends React.Component {

    state = {
        collapsed: false,
    };

    toggle = () => {
        this.setState({
            collapsed: !this.state.collapsed,
        });
    }

    render() {
        return (
            <Layout>
                <Sider
                    trigger={null}
                    collapsible
                    collapsed={this.state.collapsed}
                >
                    <div className="logo" />
                    <SiderMenu/>
                </Sider>
                <Layout>
                    <Header style={{ background: '#fff', padding: 0 }}>
                        <Icon
                            className="trigger"
                            type={this.state.collapsed ? 'right-circle' : 'left-circle'}
                            theme="twoTone"
                            onClick={this.toggle}
                            style={{ fontSize: '30px', color: '#08c' }}
                        />
                    </Header>
                    <HomePage/>
                </Layout>
            </Layout>
        );
    }
}


export default Home;